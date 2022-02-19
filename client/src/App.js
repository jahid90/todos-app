import React, { Component } from 'react';

import './App.css';

import { Events, Commands } from './library/Events';
import Emitter from './library/Emitter';
import AppHelper from './library/AppHelper';

import AddTodo from './components/AddTodo';
import TodoList from './components/TodoList';

export default class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            todos: []
        }

        this.appHelper = new AppHelper();

        this.toggleTodo = this.toggleTodo.bind(this);
        this.addTodo = this.addTodo.bind(this);
        this.deleteTodo = this.deleteTodo.bind(this);
        this.updateTodos = this.updateTodos.bind(this);

        Emitter.on(Events.TODO_ADDED, this.addTodo);
        Emitter.on(Events.TODO_TOGGLED, this.toggleTodo);
        Emitter.on(Events.TODO_DELETED, this.deleteTodo);
        Emitter.on(Events.TODOS_UPDATED, this.updateTodos);
    }

    async componentDidMount() {
        Emitter.emit(Commands.FETCH);
    }

    addTodo(todo) {
        this.setState({ todos: [...this.state.todos, todo] });
    }

    toggleTodo(id) {

        const updatedTodos = this.state.todos.map(item => item.id === id
            ? { id: item.id, text: item.text, completed: !item.completed }
            : item);

        this.setState({ todos: updatedTodos });
    }

    deleteTodo(id) {

        const updatedTodos = this.state.todos.filter(item => item.id !== id);

        this.setState({ todos: updatedTodos });
    }

    updateTodos(todos) {
        this.setState({ todos });
    }

    render() {
        return (
            <div className='app'>
                <AddTodo />
                <TodoList todos={ this.state.todos } />
            </div>
        )
    }
}
