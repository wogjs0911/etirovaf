'use client';
import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { BrowserRouter } from 'react-router-dom'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            suspense: true,
            retry: false,
            useErrorBoundary: true,
            refetchOnWindowFocus: false,
            staleTime: 1000 * 60 * 5,
            cacheTime: 1000 * 60 * 30,
        },
        mutations: {
            useErrorBoundary: true,
        },
    },
});

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <QueryClientProvider client={queryClient}>
            <ReactQueryDevtools initialIsOpen={false} />
                <BrowserRouter>
                    <App />
                </BrowserRouter>
        </QueryClientProvider>
    </React.StrictMode>
)
