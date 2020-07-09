import React, { Component } from 'react';

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

        this.props.onSubmit(text);

        this.setState({ text: '' });
    }

    render() {
        return (
            <div className='add-todo-form'>
                <h4>Add a todo</h4>
                <form onSubmit={ this.handleSubmit }>
                    <input type='text' name='todo'
                            placeholder='Todo text'
                            value={ this.state.text }
                            className='text-field'
                            onChange={ this.handleChange } />

                    <input type='submit' value='Add Todo' className='submit-btn' />
                </form>
            </div>
        )
    }
}
