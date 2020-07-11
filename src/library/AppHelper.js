import { v4 as uuidv4 } from 'uuid';

import Emitter from './Emitter';
import { Events, Commands } from './Events';

import api from '../services/todos';

class AppHelper {

    constructor() {

        Emitter.on(Commands.FETCH, this.fetchTodos);
        Emitter.on(Commands.ADD_TODO, this.addTodo);
        Emitter.on(Commands.DELETE_TODO, this.deleteTodo);
        Emitter.on(Commands.TOGGLE_TODO, this.toggleTodo);
        Emitter.on(Commands.FILTER_ALL, this.fetchTodos);
        Emitter.on(Commands.FILTER_COMPLETED, this.fetchCompletedTodos);
        Emitter.on(Commands.FILTER_INCOMPLETE, this.fetchIncompleteTodos);
    }

    fetchTodos = async () => {
        try {

            console.info('executing fetch all');

            const todos = await api.all();

            Emitter.emit(Events.TODOS_UPDATED, todos);

        } catch (error) {
            console.error(error);
        }
    }

    addTodo = async (text) => {
        try {

            console.info('executing add one');

            const todo = {
                id: uuidv4(),
                text: text,
                completed: false
            };

            await api.add(todo);

            Emitter.emit(Events.TODO_ADDED, todo);

        } catch (error) {
            console.error(error);
        }
    }

    deleteTodo = async (id) => {
        try {

            console.info('executing delete one');

            await api.delete(id);

            Emitter.emit(Events.TODO_DELETED, id);

        } catch (error) {
            console.error(error);
        }
    }

    toggleTodo = async (id) => {
        try {

            console.info('executing toggle one');

            await api.toggle(id);

            Emitter.emit(Events.TODO_TOGGLED, id);

        } catch (error) {
            console.error(error);
        }
    }

    fetchCompletedTodos = async () => {
        try {

            console.info('executing get completed');

            const todos = await api.completed();

            Emitter.emit(Events.TODOS_UPDATED, todos);

        } catch (error) {
            console.error(error);
        }
    }

    fetchIncompleteTodos = async () => {
        try {

            console.info('executing get incomplete');

            const todos = await api.incomplete();

            Emitter.emit(Events.TODOS_UPDATED, todos);

        } catch (error) {
            console.error(error);
        }
    }
}

export default AppHelper;
