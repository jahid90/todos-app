import React from 'react';
import ReactDOM from 'react-dom';

import './index.css';

import App from './App';

export class Todo extends HTMLElement {

    connectedCallback() {

        console.log('mf-todos connected');
        this.render();

    }

    disconnectedCallback() {

        console.log('mf-todos disconnected');
        
    }

    render() {

        ReactDOM.render(<App />, this);

    }

}