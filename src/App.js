import React, { Component } from 'react';
import { v4 as uuidv4 } from 'uuid';

import './App.css';

import AddTodo from './components/AddTodo';
import TodoList from './components/TodoList';

import api from './services/todos';

export default class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            todos: []
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    async componentDidMount() {
        try {

            const todos = await api.all();

            this.setState({ todos });

        } catch(error) {
            console.error(error);
        }
    }

    async onSubmit(text) {

        try {

            const todo = {
                id: uuidv4(),
                text: text,
                completed: false
            };

            api.add(todo);

            this.setState({ todos: [...this.state.todos, todo] });

        } catch(error) {
            console.error(error);
        }
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
