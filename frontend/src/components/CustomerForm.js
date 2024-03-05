import { useState } from "react";
import axios from "axios";

function Form() {
    const [customer, setCustomer] = useState({firstname: "", lastname: "", phoneNumber: "", email: ""});

    const handleOnChange = (e) => {
      //e.target.[name]=e.target.value
            const {name, value} = e.target;
            setCustomer(prevState => ({
                ...prevState, [name]: value
            }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
          const newCustomer = {firstname: customer.firstname, lastname: customer.lastname, phoneNumber: customer.phoneNumber, email: customer.email};
          const response = await axios.post('http://localhost:8080/customer', newCustomer);  
        console.log(response.data)
          //onAddNewCustomer(newCustomer);
          //setCustomer({firstname: "", lastname: "", phoneNumber: "", email: ""});
          
        } catch (error) {
          console.log('Error creating customer:', error);
        }
      };
    return (
        <form method="post" onSubmit={handleSubmit}>
        <input
          type="text"
          name="firstname"
          value={customer.firstname}
          onChange={handleOnChange}
          placeholder="First Name"
        />
        <input
          type="text"
          name="lastname"
          value={customer.lastname}
          onChange={handleOnChange}
          placeholder="Last Name"
        />
        <input
          type="text"
          name="phoneNumber"
          value={customer.phoneNumber}
          onChange={handleOnChange}
          placeholder="Phone Number"
        />
        <input
          type="text"
          name="email"
          value={customer.email}
          onChange={handleOnChange}
          placeholder="Email"
        />
        <button type="submit">Add Customer</button>
      </form>
    )
}

export default Form
