import React, { useState, useEffect, useCallback } from 'react';
import { Row, Col, Form, Button, Table } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';
import SprintsAxios from '../../apis/SprintsAxios';
import { withNavigation } from '../../routeconf';

function Add(props) {

    const empty_izvodjac = {

        ime: "",
        zanr: "",
        drzava: "  ",
        brojClanova:0

    }
    const [izvodjac, setIzvodjac] = useState(empty_izvodjac)
    const [izvodjaci, setIzvodjaci] = useState([])


    const navigate = useNavigate()

    useEffect(() => {
        getData();
      }, [])

    const getData = () => {
        getIzvojaci();
      }



      
    const getIzvojaci = () => {
        SprintsAxios.get("/izvodjac").then((result) => {
          setIzvodjaci(result.data)
        }).catch(() => {
          alert("Nije uspelo dobavljanje.");
        })
      }
    // const getIzvodjaci = useCallback(() => {
    //     SprintsAxios.get("/izvodjac")
    //     .then(res => {
    //         console.log(res.data)
    //         setIzvodjac(res.data)
    //         setIzvodjaci(res.data)

    //     })
    //     .catch(error => {
    //         console.log(error)
    //         alert('Error while fetching sprint')
    //     })
    // }, [])



    const valueInputChanged = (e) => {
        let input = e.target;

        let name = input.name;
        let value = input.value;

        setIzvodjac(izvodjac => {
            izvodjac[name] = value
            console.log(izvodjac)
            return izvodjac
        });
    }

    const create = () => {
        let izvodjacDTO = {
            ime:izvodjac.ime,
            zanr:izvodjac.zanr,
            drzava:izvodjac.drzava,
            brojClanova:izvodjac.brojClanova,
        }

        SprintsAxios.post("/izvodjac", izvodjacDTO)
        .then(() => {
            navigate('/test');
        })
        .catch(error => {
            console.log(error)
            alert('Error while creating izvodjac')
        })
    }


   
    return (
        <>
            <Row>
                <Col></Col>
                <Col xs="12" sm="10" md="8">
                    <h1>Dodaj Izvodjaca</h1>
                    <Form>
                        <Form.Group>
                            <Form.Label>Ime</Form.Label>
                            <Form.Control
                                id="ime" name="ime" onChange={(e) => valueInputChanged(e)} /> <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Zanr</Form.Label>
                            <Form.Control id="zanr" name="zanr" onChange={(e) => valueInputChanged(e)} /> <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Drzava</Form.Label>
                            <Form.Control id="drzava" name="drzava" onChange={(e) => valueInputChanged(e)} /> <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Broj Clanova</Form.Label>
                            <Form.Control id="brojClanova" name="brojClanova" onChange={(e) => valueInputChanged(e)} /> <br />
                        </Form.Group>
                        
                        <Button  onClick={create}>Dodaj</Button>
                    </Form>
                </Col>
                <Col></Col>
            </Row>

            <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Izvodjaci</th> 
          </tr>
        </thead>
        <tbody>
          {izvodjaci.map((nastup) => {
            return (
              <tr key={nastup.id}>
                <td>{nastup.ime}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>



        </>
    )
}





export default withNavigation(Add);