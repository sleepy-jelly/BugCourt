import Layout from '../../components/layouts/Layout'
import apiRequester from '../../Api/AxiosInstance';
import { useNavigate } from "react-router-dom";

import { useState } from "react";

const PageRegister = () => {

  const [inputUserNm, setUserName] = useState("");
  const [inputUserId, setUserId] = useState("");
  const [inputUserPw, setUserPw] = useState("");
  const [inputUserEmail, setUserEmail] = useState("");

  // 메시지 저장
  // const [passwordConfirmMessage, setPasswordConfirmMessage] = useState("");

  // const [isPasswordConfirm, setIsPasswordConfirm] = useState(false);

  // 값 추적
  const handleInputUserId = (e : React.ChangeEvent<HTMLInputElement>) => {
    setUserId(e.target.value);
  };
  const handleInputUserNm = (e : React.ChangeEvent<HTMLInputElement>) => {
    setUserName(e.target.value);
  };
  const handleInputUserPw = (e : React.ChangeEvent<HTMLInputElement>) => {
    setUserPw(e.target.value);
  };  
  const handleInputUserEmail = (e : React.ChangeEvent<HTMLInputElement>) => {
    setUserEmail(e.target.value);
  };  

  
  const submitHandler = (e : any) => {
    //1. 페이지 리로드 방지
    e.preventDefault();
  }
  const signUp = () => {
    console.log("Requesting sign-up..."); // Debug log
    alert("123123123");

    apiRequester
      .post("/login/registerProcess", {
        userId: inputUserId,
        userPw: inputUserPw,
        userNm: inputUserNm,
        userEmail: inputUserEmail,
      })
      .then((response) => {
        console.log("Response received:", response); // Debug log
        alert("aaa21q3123123a");
        goToLogin();
      })
      .catch((error) => {
        console.error("Error during sign-up:", error);
      });
  };
  const navigate = useNavigate();
  
  const goToLogin = () => {
    navigate("/login");
  };


  return (
    <Layout>
      <>
        <meta charSet="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <title>Bug Court</title>
        <meta content="" name="description" />
        <meta content="" name="keywords" />
        {/* =======================================================
        * Template Name: NiceAdmin
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Updated: Apr 20 2024 with Bootstrap v5.3.3
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== */}
        <main>
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
                        <img src="assets/img/logo.png" alt="" />
                        <span className="d-none d-lg-block">BugCourt</span>
                      </a>
                    </div>
                    {/* End Logo */}
                    <div className="card mb-3">
                      <div className="card-body">
                        <div className="pt-4 pb-2">
                          <h5 className="card-title text-center pb-0 fs-4">
                            Create an Account
                          </h5>
                          <p className="text-center small">
                            Enter your personal details to create account
                          </p>
                        </div>
                        <form className="row g-3 needs-validation" noValidate>
                          <div className="col-12">
                            <label htmlFor="yourName" className="form-label">
                              Your Name
                            </label>
                            <input
                              className="form-control"
                              type="name"
                              name="userNm"
                              value={inputUserNm}
                              onChange={handleInputUserNm}
                              required
                            />
                            <div className="invalid-feedback">
                              Please, enter your name!
                            </div>
                          </div>
                          <div className="col-12">
                            <label htmlFor="yourEmail" className="form-label">
                              Your Email
                            </label>
                            <input
                              className="form-control"
                              type="email"
                              name="email"
                              id="userEmail"
                              value={inputUserEmail}
                              onChange={handleInputUserEmail}
                              required
                            />
                            <div className="invalid-feedback">
                              Please enter a valid Email adddress!
                            </div>
                          </div>
                          <div className="col-12">
                            <label htmlFor="yourUsername" className="form-label">
                              Username
                            </label>
                            <div className="input-group has-validation">
                              <span
                                className="input-group-text"
                                id="inputGroupPrepend"
                              >
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
                                Please choose a username.
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
                                name="terms"
                                type="checkbox"
                                defaultValue=""
                                id="acceptTerms"
                                required
                              />
                              <label
                                className="form-check-label"
                                htmlFor="acceptTerms"
                              >
                                I agree and accept the{" "}
                                <a href="#">terms and conditions</a>
                              </label>
                              <div className="invalid-feedback">
                                You must agree before submitting.
                              </div>
                            </div>
                          </div>
                          <div className="col-12">
                            <button type="button" className="btn btn-primary w-100" onClick={signUp}>
                              Create Account
                            </button>
                          </div>
                          <div className="col-12">
                            <p className="small mb-0">
                              Already have an account?{" "}
                              <a href="pages-login.html">Log in</a>
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
                      Designed by{" "}
                      <a href="https://bootstrapmade.com/">BootstrapMade</a>
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>
        </main>
        {/* End #main */}
        <a
          href="#"
          className="back-to-top d-flex align-items-center justify-content-center"
        >
          <i className="bi bi-arrow-up-short" />
        </a>
        {/* Vendor JS Files */}
        {/* Template Main JS File */}
      </>

    </Layout>
  )
}


export default PageRegister