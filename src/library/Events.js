export const Events = {
    TODOS_UPDATED: 'todos-updated',
    TODO_ADDED: 'todo-added',
    TODO_TOGGLED: 'todo-toggled',
    TODO_DELETED: 'todo-deleted'
}

export const Commands = {
    FETCH: 'fetch',
    ADD_TODO: 'add-todo',
    TOGGLE_TODO: 'toggle-todo',
    DELETE_TODO: 'delete-todo',
    FILTER_ALL: 'filter-all',
    FILTER_COMPLETED: 'filter-completed',
    FILTER_INCOMPLETE: 'filter-incomplete'
}

export default { Events, Commands };
