import './App.css';
import React from 'react';
import About from './pages/about.js';
import Contact from './pages/contact.js';
import {Routes, Route} from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="/about" element={<About />} />
      <Route path="/contact" element={<Contact />} />
    </Routes>
  );
}

export default App;
