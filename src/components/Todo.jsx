import React, { Component } from 'react';

export default class Todo extends Component {
    render() {

        const { todo } = this.props;

        return (
            <div className='todo'>
                { todo.id } - { todo.text }
            </div>
        )
    }
}
