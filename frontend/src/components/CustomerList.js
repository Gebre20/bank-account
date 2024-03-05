import { useEffect, useState } from "react";
import axios from "axios";
import Customer from "./Customer";

function CustomerList() {
  const [customers, setCustomers] = useState([]);

  const getCustomers = async()=>{
    try {
      const res = await axios.get("http://localhost:8080/customer/all");
      const result = await res.data();
      console.log(result)
      setCustomers(result)
    } catch (error) {
      console.log(error)
    }
    
  }

  useEffect(()=>{
    getCustomers();
  }, []);

  return (
    <div>
      <h1>Customers</h1>
      <ul>
        {customers.map((customer) => (
          <Customer key={customer.id} customer={customer} />
        ))}
      </ul>
    </div>
  );
}

export default CustomerList;
