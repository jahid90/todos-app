import React, { Component } from 'react';

import Todo from './Todo';

export default class TodoList extends Component {

    state = {
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

    render() {
        return (

            <div className='todos'>
                <h4>All Todos</h4>
                {
                    this.state.todos.map(todo => <Todo todo={ todo } key={ todo.id } />)
                }
            </div>
        )
    }
}
