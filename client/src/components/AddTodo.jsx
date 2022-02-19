import React, { Component } from 'react';

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

import { Commands } from '../library/Events';
import Emitter from '../library/Emitter';

export default class AddTodo extends Component {
    constructor(props) {
        super(props);

        this.state = {
            text: ''
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ text: event.target.value });
    }

    handleSubmit(event) {

        event.preventDefault();

        const { text } = this.state;

        if (text.trim().length === 0) {
            return;
        }

        Emitter.emit(Commands.ADD_TODO, text);

        this.setState({ text: '' });
    }

    render() {
        return (
            <div className='add-todo-form'>
                <h4>Add a todo</h4>
                <form onSubmit={ this.handleSubmit }>

                    <TextField variant='outlined'
                            className='text-field'
                            placeholder='Todo text'
                            value={ this.state.text }
                            onChange={ this.handleChange } />

                    <Button variant='contained' onClick={ this.handleSubmit }>Add Todo</Button>

                </form>
            </div>
        )
    }
}
