import React, { Component } from 'react';

import Grid from '@material-ui/core/Grid';
import Chip from '@material-ui/core/Chip';
import IconButton from '@material-ui/core/IconButton';
import DoneIcon from '@material-ui/icons/Done';
import HistoryIcon from '@material-ui/icons/History';
import DeleteForeverIcon from '@material-ui/icons/DeleteForever';

import { Commands } from '../library/Events';
import Emitter from '../library/Emitter';

export default class Todo extends Component {

    constructor(props) {
        super(props);

        this.handleDelete = this.handleDelete.bind(this);
        this.handleToggle = this.handleToggle.bind(this);
    }

    handleDelete() {
        Emitter.emit(Commands.DELETE_TODO, this.props.todo.id);
    }

    handleToggle() {
        Emitter.emit(Commands.TOGGLE_TODO, this.props.todo.id);
    }

    render() {

        const { todo } = this.props;
        const classes = todo.completed ? 'completed' : '';

        return (
            <div className='todo'>
                <Grid container spacing={3} alignItems='center' justify='flex-start'>
                    <Grid item xs={10}>
                        <Chip label={ todo.text } variant='outlined' className={ classes } />
                    </Grid>
                    <Grid item xs={1}>
                        { todo.completed
                            ? <IconButton aria-label="mark incomplete"><HistoryIcon onClick={ this.handleToggle } /></IconButton>
                            : <IconButton aria-label="mark completed"><DoneIcon onClick={ this.handleToggle } /></IconButton> }
                    </Grid>
                    <Grid item xs={1}>
                        <IconButton aria-label="delete"><DeleteForeverIcon onClick={ this.handleDelete } /></IconButton>
                    </Grid>
                </Grid>
            </div>
        )
    }
}
