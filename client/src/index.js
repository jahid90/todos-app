import { Todo } from './Todo';

// Disable debug logs in production
if (window.env.NODE_ENV === 'production') {
    console.info = () => {};
}

window.customElements.define('mf-todos', Todo);
