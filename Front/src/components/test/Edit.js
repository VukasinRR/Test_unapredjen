import React, { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import SprintsAxios from "../../apis/SprintsAxios";

const Edit = () =>  {
  // constructor(props) {
  //   super(props);

  //   let task = {
  //     name: "",
  //     employee: "",
  //     points: 0,
  //     stateId: -1,
  //     sprintId: -1,
  //   };

  //   this.state = {
  //     task: task,
  //     sprints: [],
  //     states: []
  //   };
  // }

  const [linija, setLinija] = useState({})
  const [prevoznici, setPrevoznici] = useState([])
  // const [states, setStates] = useState([])// ako ima jos povezanih entiteta
  const navigate = useNavigate()
  const routeParams = useParams()

  useEffect(()=>{
    getData();
  }, [])

  const getData = () => {
    getPrevoznici();
  // getStates();// ako ima jos povezanih entiteta
    getLinija();
  }

  const getLinija = () => {
      SprintsAxios.get("/linija/" + routeParams.id)
      .then((result)=>{
        setLinija(result.data)
      }).catch(()=>{
        alert("Nije uspelo dobavljanje.");
      })
  }

  const getPrevoznici = () => {
      SprintsAxios.get("/prevoznik")
      .then((result)=>{
        setPrevoznici(result.data)
      }).catch(()=>{
        alert("Nije uspelo dobavljanje.");
      })
  }
  //ako imamo jos povezanih entiteta dobavljamo ih
  // const getStates = () => {
  //     SprintsAxios.get("/states")
  //     .then((result)=>{
  //       setStates(result.data)
  //     }).catch(()=>{
  //       alert("Nije uspelo dobavljanje.");
  //     })
  // }

  const doEdit = () => {
      SprintsAxios.put("/linija/" + routeParams.id, linija)
      .then(()=>{
        navigate("/test");
      }).catch(()=>{
        alert("Nije uspelo čuvanje.");
      })
  }

  const valueInputChange = (event) => {
    let edited = {...linija};

    const name = event.target.name;
    const value = event.target.value;

    edited[name] = value;

    setLinija(edited);
  }

  return (
    <div>
      <h1>Linija</h1>

      <Form>
        <Form.Group>
          <Form.Label>Broj Mesta</Form.Label>
          <Form.Control
            onChange={(event) => valueInputChange(event)}
            name="brojMesta"
            value={linija.brojMesta}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Cena karte</Form.Label>
          <Form.Control
            onChange={(event) => valueInputChange(event)}
            name="cenaKarte"
            value={linija.cenaKarte}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Vreme polaska</Form.Label>
          <Form.Control
            onChange={(event) => valueInputChange(event)}
            name="vremePolaska"
            value={linija.vremePolaska}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Destinacija</Form.Label>
          <Form.Control
            onChange={(event) => valueInputChange(event)}
            name="destinacija"
            value={linija.destinacija}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Prevoznik</Form.Label>
          <Form.Control
            onChange={(event) => valueInputChange(event)}
            name="prevoznikId"
            value={linija.prevoznikId}
            as="select"
          >
            <option value={-1}></option>
            {prevoznici.map((prevoznik) => {
              return (
                <option value={prevoznik.id} key={prevoznik.id}>
                  {prevoznik.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        {/* <Form.Group> // ako ima jos povezanih dodajemo
          <Form.Label>Sprint</Form.Label>
          <Form.Control
            onChange={(event) => valueInputChange(event)}
            name="sprintId"
            value={task.sprintId}
            as="select"
          >
            <option value={-1}></option>
            {sprints.map((sprint) => {
              return (
                <option value={sprint.id} key={sprint.id}>
                  {sprint.name}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group> */}
        <Button variant="primary" onClick={() => doEdit()}>
          Edit
        </Button>
      </Form>

    </div>
  );
}

export default Edit;
