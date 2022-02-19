import React from 'react';
import { render } from '@testing-library/react';
import App from './App';

test('renders all todos', () => {
  const { getByText } = render(<App />);
  const text = getByText(/All Todos/i);

  expect(text).toBeInTheDocument();
});
