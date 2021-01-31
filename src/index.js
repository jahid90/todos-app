import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';

// Disable debug logs in production
if (window.env.NODE_ENV === 'production') {
    console.info = () => {};
}

ReactDOM.render(<App />, document.getElementById('root'));
