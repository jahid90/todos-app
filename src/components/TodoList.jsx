import React, { Component } from 'react';

import Todo from './Todo';

export default class TodoList extends Component {

    constructor(props) {
        super(props);
    }

    render() {

        const { todos } = this.props;

        return (

            <div className='todos'>
                <h4>All Todos</h4>
                {
                    todos.map(todo => <Todo todo={ todo } key={ todo.id } />)
                }
            </div>
        )
    }
}
