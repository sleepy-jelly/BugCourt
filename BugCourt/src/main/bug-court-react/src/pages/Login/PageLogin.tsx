import React, { useState } from 'react';
import Layout from '../../components/layouts/Layout';
import apiRequester from '../../Api/AxiosInstance';
import { useNavigate } from "react-router-dom";

interface LoginFormData {
  userId: string;
  userPw: string;
  rememberMe: boolean;
}

interface LoginError {
  userId?: string;
  userPw?: string;
  general?: string;
}

const Login: React.FC = () => {
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState(false);
  const [formData, setFormData] = useState<LoginFormData>({
    userId: '',
    userPw: '',
    rememberMe: false
  });
  const [errors, setErrors] = useState<LoginError>({});

  const validateForm = (): boolean => {
    const newErrors: LoginError = {};
    
    if (!formData.userId.trim()) {
      newErrors.userId = 'User ID is required';
    }
    
    if (!formData.userPw) {
      newErrors.userPw = 'Password is required';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value
    }));
    // Clear error when user starts typing
    if (errors[name as keyof LoginError]) {
      setErrors(prev => ({ ...prev, [name]: undefined }));
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    
    if (!validateForm()) {
      return;
    }

    setIsLoading(true);
    setErrors({});

    const params = new URLSearchParams();
    params.append("userId", formData.userId);
    params.append("userPw", formData.userPw);

    try {
      const response = await apiRequester.post("/login/loginProcess", params, {
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
      });

      if (response.data.token) {
        // Store the JWT token
        localStorage.setItem('token', response.data.token);
        
        // Set the token in axios default headers
        apiRequester.defaults.headers.common['Authorization'] = `Bearer ${response.data.token}`;
        
        // Navigate to dashboard
        navigate("/dash-board");
      } else {
        setErrors({ general: 'Invalid credentials' });
      }
    } catch (error) {
      console.error("Login error:", error);
      setErrors({ general: 'An error occurred during login. Please try again.' });
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <Layout>
      <div className="container">
        <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
          <div className="container">
            <div className="row justify-content-center">
              <div className="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                <div className="d-flex justify-content-center py-4">
                  <a href="/login/login-page" className="logo d-flex align-items-center w-auto">
                    {/* <img src="/img/logo.png" alt="Bug Court Logo" /> */}
                    <span className="d-none d-lg-block">Bug Court</span>
                  </a>
                </div>

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

                    {errors.general && (
                      <div className="alert alert-danger" role="alert">
                        {errors.general}
                      </div>
                    )}

                    <form className="row g-3 needs-validation" onSubmit={handleSubmit} noValidate>
                      <div className="col-12">
                        <label htmlFor="userId" className="form-label">
                          User ID
                        </label>
                        <div className="input-group has-validation">
                          <span className="input-group-text" id="inputGroupPrepend">
                            @
                          </span>
                          <input
                            className={`form-control ${errors.userId ? 'is-invalid' : ''}`}
                            type="text"
                            name="userId"
                            id="userId"
                            value={formData.userId}
                            onChange={handleInputChange}
                            disabled={isLoading}
                            required
                          />
                          {errors.userId && (
                            <div className="invalid-feedback">
                              {errors.userId}
                            </div>
                          )}
                        </div>
                      </div>

                      <div className="col-12">
                        <label htmlFor="userPw" className="form-label">
                          Password
                        </label>
                        <input
                          className={`form-control ${errors.userPw ? 'is-invalid' : ''}`}
                          type="password"
                          name="userPw"
                          id="userPw"
                          value={formData.userPw}
                          onChange={handleInputChange}
                          disabled={isLoading}
                          required
                        />
                        {errors.userPw && (
                          <div className="invalid-feedback">
                            {errors.userPw}
                          </div>
                        )}
                      </div>

                      <div className="col-12">
                        <div className="form-check">
                          <input
                            className="form-check-input"
                            type="checkbox"
                            name="rememberMe"
                            id="rememberMe"
                            checked={formData.rememberMe}
                            onChange={handleInputChange}
                            disabled={isLoading}
                          />
                          <label className="form-check-label" htmlFor="rememberMe">
                            Remember me
                          </label>
                        </div>
                      </div>

                      <div className="col-12">
                        <button 
                          className="btn btn-primary w-100" 
                          type="submit"
                          disabled={isLoading}
                        >
                          {isLoading ? (
                            <>
                              <span className="spinner-border spinner-border-sm me-1" role="status" aria-hidden="true"></span>
                              Logging in...
                            </>
                          ) : (
                            'login'
                          )}
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
              </div>
            </div>
          </div>
        </section>
      </div>
      {/* End #main */}
      <a href="#" className="back-to-top d-flex align-items-center justify-content-center"><i className="bi bi-arrow-up-short"></i></a>
    </Layout>
  );
};

export default Login;