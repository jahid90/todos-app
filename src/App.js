import React, { Component } from 'react'

import './App.css';

import AddTodo from './components/AddTodo';
import TodoList from './components/TodoList';

export default class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            todos: [
                {
                    id: 1,
                    text: 'A todo',
                    completed: false
                },
                {
                    id: 2,
                    text: 'Another one',
                    completed: false
                }
            ]
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit(text) {
        this.setState({
            todos: [...this.state.todos, {
                id: this.state.todos.length + 1,
                text: text,
                completed: false
            }]
        });
    }

    render() {
        return (
            <div className='app'>
                <AddTodo onSubmit={ this.onSubmit }/>
                <TodoList todos={ this.state.todos } />
            </div>
        )
    }
}
