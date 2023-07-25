import React, { useEffect, useState } from "react";
import { Table, Button, Form, ButtonGroup, Collapse } from "react-bootstrap";
import SprintsAxios from "../../apis/SprintsAxios";
import { useNavigate } from "react-router-dom";

const Glavna = () => {
  //potrebno je zbog create-a
  const emptyNastup = {
    festivalId: -1,
    izvodjacId: -1,

  }
  const [nastup, setNastup] = useState(emptyNastup)
  const [nastupi, setNastupi] = useState([])
  const [festivali, setFestivali] = useState([])//ispod dodamo jos entiteta ako ima povezanih
  const [izodjaci, setIzvodjaci] = useState([])//ispod dodamo jos entiteta ako ima povezanih
  const [search, setSearch] = useState({ festivalId: -1, izvodjacId: -1 }) // dodamo parametre za pretragu moraju da se poklapaju sa backend u kontroloru i u pretrazi u repository
  const [showSearch, setShowSearch] = useState(false)
  const [pageNo, setPageNo] = useState(0)
  const [totalPages, setTotalPages] = useState(1)
  //   const [sprintSum, setSprintSum] = useState("")// za poseban zadatak ako se trazi nesto dodaj, oduzmi, poeni, bodovi itd
  const navigate = useNavigate()

  useEffect(() => {
    getData();
  }, [])

  const getData = () => {
    getFestivali();
    getIzvojaci();
    getNastupi(0);
  }

  const getNastupi = (page) => {
    let config = {
      params: {
        pageNo: page
      }
    };

    //Sledeca if-ovi su tu zbog search-a
    if (search.festivalId != -1) {
      config.params.festivalId = search.festivalId;
    }

    if (search.izvodjacId != -1) {
      config.params.izvodjacId = search.izvodjacId;
    }

    SprintsAxios.get("/nastup", config)
      .then((result) => {
        //   const sprintSum = result.headers["sprint-total"]?result.headers["sprint-total"]:""; // poseban zadatak
        setPageNo(page)
        setNastupi(result.data)
        setTotalPages(result.headers["total-pages"])
        //   setSprintSum(sprintSum) // poseban zadatak
      }).catch(() => {
        alert("Nije uspelo dobavljanje.");
      })
  }

  const getFestivali = () => {
    SprintsAxios.get("/festival").then((result) => {
      setFestivali(result.data)
    }).catch(() => {
      alert("Nije uspelo dobavljanje.");
    })
  }
  const getIzvojaci = () => {
    SprintsAxios.get("/izvodjac").then((result) => {
      setIzvodjaci(result.data)
    }).catch(() => {
      alert("Nije uspelo dobavljanje.");
    })
  }
  const goToEdit = (editId) => {
    navigate("/test/edit/" + editId);
  }



  const doAdd = () => {
    SprintsAxios.post("/nastup/", nastup)
      .then(() => {
        //bitno je da bi "resetovali" polja za kreiranje nakon kreiranja
        let nastup = {
          festivalId: -1,
          izvodjacId: -1
        };
        setNastup(nastup)
        getNastupi(0);
      }).catch(() => {
        alert("Nije uspelo dodavanje.");
      })
  }

  const doDelete = (deleteId) => {
    SprintsAxios.delete("/nastup/" + deleteId)
      .then(() => {
        var nextPage
        if (pageNo == totalPages - 1 && nastup.length == 1) {
          nextPage = pageNo - 1
        } else {
          nextPage = pageNo
        }
        getNastupi(nextPage);
      }).catch((error) => {
        alert("Nije uspelo brisanje.");
      })
  }

  const addValueInputChange = (event) => {
    let newTask = { ...nastup }

    const name = event.target.name;
    const value = event.target.value;

    newTask[name] = value
    setNastup(newTask);
  }

  const searchValueInputChange = (event) => {
    let newSearch = { ...search }

    const name = event.target.name;
    const value = event.target.value;

    newSearch[name] = value
    setSearch(newSearch);
  }

  const doSearch = () => {
    getNastupi(0);
  }


  return (
    <div>
      <h1>NASTUPI</h1>
      {/*Deo za ADD*/}
      {window.localStorage['role'] == "ROLE_ADMIN" ?
        <Form>
          
          <Form.Group>
            <Form.Label>Festivali</Form.Label>
            <Form.Control
              onChange={(event) => addValueInputChange(event)}
              name="festivalId"
              value={nastup.festivalId}
              as="select"
            >
              <option value={-1}></option>
              {festivali.map((festival) => {
                return (
                  <option value={festival.id} key={festival.id}>
                    {festival.naziv}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Izvodjaci</Form.Label>
            <Form.Control
              onChange={(event) => addValueInputChange(event)}
              name="izvodjacId"
              value={nastup.izvodjacId}
              as="select"
            >
              <option value={-1}></option>
              {izodjaci.map((izodjac) => {
                return (
                  <option value={izodjac.id} key={izodjac.id}>
                    {izodjac.ime}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>
          {/* <Button disabled = {!canCreateTask()} variant="primary" onClick={() => doAdd()}>
          Add
        </Button> */}
          <Button onClick={() => doAdd()}>
            Add
          </Button>
        </Form> : null}

      {/*Deo za Search*/}
      <Form.Group style={{ marginTop: 35 }}>
        <Form.Check type="checkbox" label="Show search form" onClick={(event) => setShowSearch(event.target.checked)} />
      </Form.Group>
      <Collapse in={showSearch}>
        <Form style={{ marginTop: 10 }}>
          {/* <Form.Group>
            <Form.Label>Destinacija</Form.Label>
            <Form.Control
              value={search.destinacija}
              name="destinacija"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group> */}
          <Form.Group>
            <Form.Label>Festivali</Form.Label>
            <Form.Control
              onChange={(event) => searchValueInputChange(event)}
              name="festivalId"
              value={search.festivalId}
              as="select"
            >
              <option value={-1}></option>
              {festivali.map((festival) => {
                return (
                  <option value={festival.id} key={festival.id}>
                    {festival.naziv}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Izvodjaci</Form.Label>
            <Form.Control
              onChange={(event) => searchValueInputChange(event)}
              name="izvodjacId"
              value={search.izvodjacId}
              as="select"
            >
              <option value={-1}></option>
              {izodjaci.map((izvodjac) => {
                return (
                  <option value={izvodjac.id} key={izvodjac.id}>
                    {izvodjac.ime}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>
          <Button onClick={() => doSearch()}>Search</Button>
        </Form>
      </Collapse>

      {/*Deo za prikaz Task-a*/}
      <ButtonGroup style={{ marginTop: 25, float: "right" }}>
        <Button
          style={{ margin: 3, width: 90 }}
          disabled={pageNo == 0} onClick={() => getNastupi(pageNo - 1)}>
          Previous
        </Button>
        <Button
          style={{ margin: 3, width: 90 }}
          disabled={pageNo == totalPages - 1} onClick={() => getNastupi(pageNo + 1)}>
          Next
        </Button>
      </ButtonGroup>

      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Festival</th>
            <th>Izvodjac</th> 
            <th colSpan={2}>Actions</th>
          </tr>
        </thead>
        <tbody>
          {nastupi.map((nastup) => {
            return (
              <tr key={nastup.id}>
                <td>{nastup.festivalNaziv}</td>
                <td>{nastup.izvodjacIme}</td>
                <td>

                  {/* <Button
                  disabled={nastup.stateId === 3}
                  variant="info"
                  onClick={() => changeState(nastup.id)}
                  >
                    Rezervisi
                  </Button> */}
                  {window.localStorage['role'] == "ROLE_ADMIN" ?
                    [<Button
                      variant="warning"
                      onClick={() => goToEdit(nastup.id)}
                      style={{ marginLeft: 5 }}
                    >
                      Edit
                    </Button>,

                    <Button
                      variant="danger"
                      onClick={() => doDelete(nastup.id)}
                      style={{ marginLeft: 5 }}
                    >
                      Delete
                    </Button>] : null}
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
      {/* <h2 hidden={sprintSum == ""}>Suma bodova za sprint je {sprintSum}</h2> */}
    </div>
  );
}

export default Glavna
