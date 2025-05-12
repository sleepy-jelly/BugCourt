import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const Sidebar: React.FC = () => {
  const [isProblemsOpen, setIsProblemsOpen] = useState(false);

  const toggleProblems = () => {
    setIsProblemsOpen(!isProblemsOpen);
  };

  return (
    <aside id="sidebar" className="sidebar">
      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <Link to="/dash-board" className="nav-link">
            <i className="bi bi-grid" />
            <span>Dashboard</span>
          </Link>
        </li>

        <li className="nav-item">
          <a
            className={`nav-link ${isProblemsOpen ? '' : 'collapsed'}`}
            onClick={toggleProblems}
            style={{ cursor: 'pointer' }}
          >
            <i className="bi bi-layout-text-window-reverse" />
            <span>Problems</span>
            <i className={`bi bi-chevron-down ms-auto ${isProblemsOpen ? 'rotate-180' : ''}`} />
          </a>
          <ul
            className={`nav-content collapse ${isProblemsOpen ? 'show' : ''}`}
            data-bs-parent="#sidebar-nav"
          >
            <li>
              <Link to="/bbs/general-problem">
                <i className="bi bi-circle" />
                <span>General Problems</span>
              </Link>
            </li>
            <li>
              <Link to="/bbs/discuss">
                <i className="bi bi-circle" />
                <span>Discuss</span>
              </Link>
            </li>
          </ul>
        </li>

        <li className="nav-heading">Pages</li>
        <li className="nav-item">
          <Link to="/profile" className="nav-link">
            <i className="bi bi-person" />
            <span>Profile</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/faq" className="nav-link">
            <i className="bi bi-question-circle" />
            <span>F.A.Q</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/contact" className="nav-link">
            <i className="bi bi-envelope" />
            <span>Contact</span>
          </Link>
        </li>
      </ul>
    </aside>
  );
};

export default Sidebar; 