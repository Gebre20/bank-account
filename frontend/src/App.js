import Form from "./components/CustomerForm";
import CustomerList from "./components/CustomerList";
import LoginForm from "./components/LoginForm";

function App() {
  

  // const addNewCustomer = async(customer) => {
  //   try {
  //     console.log(customer)
  //     const response = await axios.post('/api/customer', {customer});
  //     console.log(response.data);
  //     setCustomers([...customers, response.data]);
  //   } catch (error) {
  //     console.error('Error creating customer:', error);
  //   }
  // }
  return (
    <div>
      <LoginForm/>
      <Form/>
      <CustomerList/>
    </div>
  );
}

export default App;
