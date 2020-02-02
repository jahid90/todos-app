import React from 'react';
import { render } from '@testing-library/react';
import App from './App';

test('renders hello world', () => {
  const { getByText } = render(<App />);
  const text = getByText(/Hello World!/i);
  expect(text).toBeInTheDocument();
});
