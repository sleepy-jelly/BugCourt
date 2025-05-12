import Header from './Header'
import Footer from './Footer'
import Sidebar from './Sidebar'
import { useLocation, Outlet } from 'react-router-dom'

const Layout = () => {
  const location = useLocation();
  const isLoginPage = location.pathname === '/login/login-page';
  const isRegisterPage = location.pathname === '/login/register-page';
  const isErrorPage = location.pathname === '*';

  return(
    <>
      {!isLoginPage && !isRegisterPage && !isErrorPage && <Header/>}
      {!isLoginPage && !isRegisterPage && !isErrorPage && <Sidebar/>}
      <main><Outlet/></main>
      <Footer/>
    </>
  )
}

export default Layout