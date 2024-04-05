import { CustomerRepository } from '../database/repository/customers.js'

export class CustomerService {
  constructor() {
    this.repository = new CustomerRepository()
  }

  async getDetails(id) {
    const existingCustomer = await this.repository.findCustomerById(id)
    return existingCustomer
  }
}
