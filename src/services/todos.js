import axios from 'axios';

const baseUrl = 'http://localhost:8080';

const getAllTodos = async () => {

    const response = await axios.get(`${baseUrl}/todos`);

    if (response.error) {
        throw new Error(response.error);
    }

    console.debug("Received:", JSON.stringify(response.data, null, 2));

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
    add: addTodo,
    delete: deleteTodo,
    toggle: toggleTodo
}

export default api;
