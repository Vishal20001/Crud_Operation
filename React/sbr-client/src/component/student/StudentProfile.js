import React, { useState,useEffect } from 'react'
import axios from 'axios'
import { useParams } from 'react-router-dom';

const StudentProfile = () => {

    const{id}=useParams();

    const [student,setStudent]=useState({
        firstName:'',
        lastName:'',
        email:'',
        department:''
        
      });
    
    useEffect(()=> {
        loadstudent();
      }, []);
      
      
    const loadstudent=async()=>{
        const result =await axios.get(`http://localhost:8080/students/student/${id}`);
        setStudent(result.data);      
    }

  return (
    <section className='shadow' style={{background:"whitesmoke" }}>
        <div className='container py-5'>
            <div className='row'>
                <div className='col-lg-3'>
                    <div className='card mb-4'>
                        <div className='card-body text-center'>
                            <img src='data:image/jpeg;base64,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' alt='avatar' className='rounded-circle img-fluid' style={{width:150}}/>
                            <h5 className='my-3'>{`${student.firstName}${student.lastName}`}</h5>
                            <div className='d-flex justify-content-center mb-2'>
                                <button type='button' className='btn btn-outline-primary'>
                                    Call
                                </button>
                                <button type='button' className='btn btn-outline-warning'>
                                    Message
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div className='col-lg-9'>
                    <div className='card mb-4'>
                        <div className='card-body'>
                            <hr/>

                            <div className='row'>
                                <div className='col-sm-3'>
                                    <h5 className='mb-0'>First Name</h5>
                                </div>
                                <div className='col-sm-9'>
                                    <p className='text-muted mb-0'>{student.firstName}</p>
                                </div>
                            </div>

                            <hr/>

                            <div className='row'>
                                <div className='col-sm-3'>
                                    <h5 className='mb-0'>Last Name</h5>
                                </div>
                                <div className='col-sm-9'>
                                    <p className='text-muted mb-0'>{student.lastName}</p>
                                </div>
                            </div>

                            <hr/>

                            <div className='row'>
                                <div className='col-sm-3'>
                                    <h5 className='mb-0'>Email</h5>
                                </div>
                                <div className='col-sm-9'>
                                    <p className='text-muted mb-0'>{student.email}</p>
                                </div>
                            </div>

                            <hr/>

                            <div className='row'>
                                <div className='col-sm-3'>
                                    <h5 className='mb-0'>Department</h5>
                                </div>
                                <div className='col-sm-9'>
                                    <p className='text-muted mb-0'>{student.department}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
  )
}

export default StudentProfile