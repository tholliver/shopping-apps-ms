import { customers } from '../schemas/index.js'
import { eq } from 'drizzle-orm'
import dbConn from '../connection.js'

export class CustomerRepository {
  async createCustomer() {}

  async findCustomerByEmail(email) {}
  async findCustomerById(id) {
    const userFound = await dbConn.query.customers.findMany({
      where: eq(customers.id, id),
    })

    return userFound
  }
  async getWishlist(id) {}
}
