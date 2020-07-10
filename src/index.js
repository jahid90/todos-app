import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';

// Disable debug logs in production
if (process.env.NODE_ENV === 'production') {
    console.debug = (args) => {};
}

ReactDOM.render(<App />, document.getElementById('root'));
