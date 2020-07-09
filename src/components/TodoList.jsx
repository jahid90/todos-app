import React, { Component } from 'react';

import Todo from './Todo';

export default class TodoList extends Component {

    constructor(props) {
        super(props);

        this.handleDelete = this.handleDelete.bind(this);
    }

    handleDelete(id) {
        this.props.onDelete(id);
    }

    render() {

        const { todos } = this.props;

        return (

            <div className='todos'>
                <h4>All Todos</h4>
                {
                    todos.map(todo => <Todo todo={ todo } key={ todo.id } onDelete={ this.handleDelete } />)
                }
            </div>
        )
    }
}
