import { BrowserRouter as BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './components/layouts/Layout';

import PageLogin from './pages/Login/PageLogin.tsx';
import PageRegister from './pages/Login/PageRegister.tsx';
import UserDashBoard from './pages/board/DashBoard/UserDashBoard.tsx';
import PageError404 from './pages/Common/PageError404.tsx';
import GeneralProblem from './pages/bbs/GeneralProblem.tsx';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Routes without Layout */}
        <Route path="/login/login-page" element={<PageLogin/>} />
        <Route path="/login/register-page" element={<PageRegister/>} />
        <Route path="*" element={<PageError404/>} />

        {/* Routes with Layout */}
        <Route element={<Layout />}>
          <Route path="/dash-board" element={<UserDashBoard/>} />
          <Route path="/bbs/general-problem" element={<GeneralProblem/>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App  
