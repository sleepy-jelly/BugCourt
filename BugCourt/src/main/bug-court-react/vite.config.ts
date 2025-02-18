import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // proxy: 'http://localhost:8080'
    proxy: {
      '/api': {
        target: 'http://localhost:8080/',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    },
      // '/login': {
      //   target: 'http://localhost:8080', // If you have a separate route for login
      //   changeOrigin: true,
      //   secure: false,e
      //   rewrite: (path) => path.replace(/^\/login/, '') // Adjust as neded for your login path
      // }
    // },
    // cors : {
    //   "origin": "http://localhost:8080",
    //   "methods": "GET,HEAD,PUT,PATCH,POST,DELETE",
    //   "preflightContinue": false,
    //   "optionsSuccessStatus": 302
    // }
  }
})
