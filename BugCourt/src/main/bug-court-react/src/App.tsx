import { BrowserRouter as BrowserRouter, Routes, Route } from 'react-router-dom';

import PageLogin from './pages/Login/PageLogin.tsx';
import PageRegister from './pages/Login/PageRegister.tsx';
import UserDashBoard from './pages/board/DashBoard/UserDashBoard.tsx';
import PageError404 from './pages/Common/PageError404.tsx';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login/login-page" element={<PageLogin/>} />

        <Route path="/login/register-page" element={<PageRegister/>} />

        <Route path="/dash-board" element={<UserDashBoard/>} />


        <Route path="*" element={<PageError404/>} />

      </Routes>
    </BrowserRouter>
  );
}


export default App  
