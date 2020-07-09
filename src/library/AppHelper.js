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

        console.log('app-helper initialized');
    }

    fetchTodos = async () => {
        try {

            console.log('executing fetch all');

            const todos = await api.all();

            Emitter.emit(Events.TODOS_FETCHED, todos);

        } catch(error) {
            console.error(error);
        }
    }

    addTodo = async (text) => {
        try {

            console.log('executing add one');

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

            console.log('executing delete one');

            await api.delete(id);

            Emitter.emit(Events.TODO_DELETED, id);

        } catch (error) {
            console.error(error);
        }
    }

    toggleTodo = async (id) => {
        try {

            console.log('executing toggle one');

            await api.toggle(id);

            Emitter.emit(Events.TODO_TOGGLED, id);

        } catch (error) {
            console.error(error);
        }
    }
}

export default AppHelper;
