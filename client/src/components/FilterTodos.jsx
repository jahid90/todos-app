import React, { Component } from 'react';

import ToggleButton from '@material-ui/lab/ToggleButton';
import ToggleButtonGroup from '@material-ui/lab/ToggleButtonGroup';

import { Commands } from '../library/Events';
import Emitter from '../library/Emitter';

export default class FilterTodos extends Component {

    constructor(props) {
        super(props);

        this.state = {
            filter: 'all'
        };

        this.handleFiltered = this.handleFiltered.bind(this);
    }

    handleFiltered(event, value) {

        if (value === null) {
            value = 'all';
        }

        this.setState({ filter: value });

        switch(value) {
            case 'completed':
                Emitter.emit(Commands.FILTER_COMPLETED);
                break;

            case 'incomplete':
                Emitter.emit(Commands.FILTER_INCOMPLETE);
                break;

            default:
                Emitter.emit(Commands.FILTER_ALL);
                break;
        }
    }

    render() {
        return (
            <div className='filter'>
                <h4>Filter Todos</h4>
                <ToggleButtonGroup value={ this.state.filter } exclusive onChange={ this.handleFiltered }>
                    <ToggleButton value="all" aria-label="all todos">
                        All
                    </ToggleButton>
                    <ToggleButton value="completed" aria-label="completed todos">
                        Completed
                    </ToggleButton>
                    <ToggleButton value="incomplete" aria-label="incomplete todos">
                        Incomplete
                    </ToggleButton>
                </ToggleButtonGroup>
            </div>
        )
    }
}
