import React, { Component } from 'react';

import Grid from '@material-ui/core/Grid';
import DeleteForeverIcon from '@material-ui/icons/DeleteForever';

export default class Todo extends Component {

    constructor(props) {
        super(props);

        this.handleDelete = this.handleDelete.bind(this);
    }

    handleDelete() {
        this.props.onDelete(this.props.todo.id);
    }

    render() {

        const { todo } = this.props;

        return (
            <div className='todo'>
                <Grid container spacing={3}>
                    <Grid item xs={11}>
                        { todo.text }
                    </Grid>
                    <Grid item xs={1}>
                        <DeleteForeverIcon className='icon' onClick={ this.handleDelete } />
                    </Grid>
                </Grid>
            </div>
        )
    }
}
