import Layout from '../../components/layouts/Layout'
import apiRequester from '../../Api/AxiosInstance';
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Login = () => {

  const [inputUserId, setUserId] = useState("");
  const [inputUserPw, setUserPw] = useState("");

  // handling Input
  const handleInputUserId = (e : React.ChangeEvent<HTMLInputElement>) => {
    setUserId(e.target.value);
  };
  const handleInputUserPw = (e : React.ChangeEvent<HTMLInputElement>) => {
    setUserPw(e.target.value);
  };  


  const params = new URLSearchParams();
  params.append("userId", inputUserId);
  params.append("userPw", inputUserPw);


  const login = () => {
    console.log("Requesting login..."); // Debug log
    alert("Requesting");
    console.log("Requesting ..."+ inputUserId+inputUserPw); // Debug log

    apiRequester
      .post("/login/loginProcess", params, {
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
        withCredentials: true, // Ensures cookies are sent if needed
      })
      .then((response ) => {
        
        console.log("Response received:", response); // Debug log
        alert("Response received");

        goToBbs();



      })
      .catch((error) => {
        console.error("Error during login:", error);
      });
  };
  const navigate = useNavigate();
  
  const goToBbs = () => {
    navigate("/dash-board");
  };


  return (
    <Layout>
     <>
        <div className="container">
          <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div className="container">
              <div className="row justify-content-center">
                <div className="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                  <div className="d-flex justify-content-center py-4">
                    <a
                      href="index.html"
                      className="logo d-flex align-items-center w-auto"
                    >
                      <img src="/img/logo.png" alt="" />
                      <span className="d-none d-lg-block">Bug Court</span>
                    </a>
                  </div>
                  {/* End Logo */}
                  <div className="card mb-3">
                    <div className="card-body">
                      <div className="pt-4 pb-2">
                        <h5 className="card-title text-center pb-0 fs-4">
                          Login to Your Account
                        </h5>
                        <p className="text-center small">
                          Enter your userId &amp; password to login
                        </p>
                      </div>
                      <form className="row g-3 needs-validation" noValidate>
                        <div className="col-12">
                          <label htmlFor="userId" className="form-label">
                          userId
                          </label>
                          <div className="input-group has-validation">
                            <span className="input-group-text" id="inputGroupPrepend">
                              @
                            </span>
                            <input
                               className="form-control"
                               type="text"
                               name="userId"
                               id="userId"
                               value={inputUserId}
                               onChange={handleInputUserId}
                               required
                            />
                            <div className="invalid-feedback">
                              Please enter your User-ID.
                            </div>
                          </div>
                        </div>
                        <div className="col-12">
                          <label htmlFor="yourPassword" className="form-label">
                            Password
                          </label>
                          <input
                             className="form-control"
                             type="password"
                             name="userPw"
                             id="userPw"
                             value={inputUserPw}
                             onChange={handleInputUserPw}
                             required
                          />
                          <div className="invalid-feedback">
                            Please enter your password!
                          </div>
                        </div>
                        <div className="col-12">
                          <div className="form-check">
                            <input
                              className="form-check-input"
                              type="checkbox"
                              name="remember"
                              defaultValue="true"
                              id="rememberMe"
                            />
                            <label className="form-check-label" htmlFor="rememberMe">
                              Remember me
                            </label>
                          </div>
                        </div>
                        <div className="col-12">
                          <button className="btn btn-primary w-100" type="button" onClick={login}>
                            Login
                          </button>
                        </div>
                        <div className="col-12">
                          <p className="small mb-0">
                            Don't have account?{" "}
                            <a href="/api/login/viewPageRegister">Create an account</a>
                          </p>
                        </div>
                      </form>
                    </div>
                  </div>
                  <div className="credits">
                    {/* All the links in the footer should remain intact. */}
                    {/* You can delete the links only if you purchased the pro version. */}
                    {/* Licensing information: https://bootstrapmade.com/license/ */}
                    {/* Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ */}
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
        {/* End #main */}
        <a href="#" className="back-to-top d-flex align-items-center justify-content-center"><i className="bi bi-arrow-up-short"></i></a>
     </>
    </Layout>
  )
}





export default Login