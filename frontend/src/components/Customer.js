function Customer({customer}) {
    return (
        <>
            <li>First Name: {customer.firstname}</li>
            <li>Last Name: {customer.lastname}</li>
            <li>Phone Number: {customer.phoneNumber}</li>
            <li>Email: {customer.email}</li>
        </>
    )
}

export default Customer;
