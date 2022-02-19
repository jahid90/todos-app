import axios from 'axios';

const baseUrl = window.env.TODOS_SERVICE_ENDPOINT || 'http://localhost:8080';
console.info(`Service endpoint loaded: ${baseUrl}`);

const getAllTodos = async () => {

    const response = await axios.get(`${baseUrl}/todos`);

    if (response.error) {
        throw new Error(response.error);
    }

    return response.data;
}

const getCompletedTodos = async () => {

    const response = await axios.get(`${baseUrl}/todos?completed=true`);

    if (response.error) {
        throw new Error(response.error);
    }

    return response.data;
}

const getIncompleteTodos = async () => {

    const response = await axios.get(`${baseUrl}/todos?completed=false`);

    if (response.error) {
        throw new Error(response.error);
    }

    return response.data;
}

const addTodo = async (todo) => {

    const response = await axios.post(`${baseUrl}/todos`, todo);

    if (response.error) {
        throw new Error(response.error);
    }
}

const deleteTodo = async (id) => {

    const response = await axios.delete(`${baseUrl}/todo/${id}`);

    if (response.error) {
        throw new Error(response.error);
    }
}

const toggleTodo = async (id) => {

    const response = await axios.put(`${baseUrl}/todo/toggle/${id}`);

    if (response.error) {
        throw new Error(response.error);
    }
}

const api = {
    all: getAllTodos,
    completed: getCompletedTodos,
    incomplete: getIncompleteTodos,
    add: addTodo,
    delete: deleteTodo,
    toggle: toggleTodo
}

export default api;
