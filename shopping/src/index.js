import { PORT } from './config/index.js'

import express from 'express'

const app = express()

app.get('/', (req, res, next) => {
  return res.status(200).json({ msg: 'hello from shopping' })
})

app.listen(PORT, () => {
  console.log(`Shopping server running on: http://localhost:${PORT}`)
})
