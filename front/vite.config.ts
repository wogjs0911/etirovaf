import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tsconfigPaths from "vite-tsconfig-paths";

export default defineConfig({
  plugins: [react(), tsconfigPaths()],
  server: {
    watch: {
      usePolling: true,
    },
    host: true, // Here
    strictPort: true,
    port: 3000
  },
  // optimizeDeps: {
  //   include: ['front'], // 번들링할 패키지 이름 추가
  // },
  // build: {
  //   commonjsOptions: {
  //     include: [/front/, /node_modules/],
  //   },
  // },
})

