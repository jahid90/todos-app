import React from 'react';

import './App.css';

import AddTodo from './components/AddTodo';
import TodoList from './components/TodoList';

const App = () => (
    <div className='app'>
        <AddTodo />
        <TodoList />
    </div>
);

export default App;
