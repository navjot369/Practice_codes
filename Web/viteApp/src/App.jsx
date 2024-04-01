import { useState, useEffect } from 'react'
import axios from 'axios';
import './App.css'

function App() {
  const [arr, setArr] = useState([]);
  useEffect(() => {
    axios.get('/api/names')
    .then((response) => {
      setArr(response.data);
      console.log(response);
    })
    .catch((err) => {
      console.log(err);
    })
  }, []);
  return (
    <div>
      <h1>Total: {arr.length}</h1>
      {
        arr.map((item, ind) => (
          <div key={ind}>
            <h6>{item.id}. {item.name}</h6>
          </div>
        ))
      }
    </div>
  )
}

export default App
