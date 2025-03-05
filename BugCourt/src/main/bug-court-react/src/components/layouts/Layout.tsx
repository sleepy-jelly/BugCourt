import Header from './Header'
import Footer from './Footer'
import { useLocation } from 'react-router-dom'

const Layout = (props : {children : React.ReactNode})=>{
  const location = useLocation();
  const isLoginPage = location.pathname === '/login/login-page';
  const isRegisterPage = location.pathname === '/login/register-page';


  return(
    <>
      {!isLoginPage && !isRegisterPage && <Header/>}
      <main>{props.children}</main>
      <Footer/>
    </>
  )
}
export default Layout