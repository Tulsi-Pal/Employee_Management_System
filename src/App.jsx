import { useState } from 'react'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import FooterComponent from './components/FooterComponent.jsx'
import HeaderComponent from './components/HeaderComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'  // ✅ Route add kiya
import EmployeeComponent from './components/EmployeeComponent.jsx'

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />

        <Routes>
          {/* http://localhost:3001/ */}
          <Route path='/' element={<ListEmployeeComponent />} />

          {/* http://localhost:3001/employees */}
          <Route path='/employees' element={<ListEmployeeComponent />} />
          {/* http://localhost:3001/add-employees */}
          <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
          {/* http://localhost:3001/edit-employees/1 */}
          <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
        </Routes>

        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
