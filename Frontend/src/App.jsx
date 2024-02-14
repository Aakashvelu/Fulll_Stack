import { createBrowserRouter, RouterProvider } from "react-router-dom"
import Home from "./pages/Home"
import { Suspense, lazy } from "react";
import Spinner from "./components/Spinner";
import Login from "./pages/Login";
import Register from "./pages/Register";
import InquiryForm from "./pages/Inquiry";
import ViewAllCourses from "./pages/Courses";
import ProfilePage from "./pages/Profile";
import Dashboard from "./pages/Dashboard";
import Manageteam from "./pages/Manageteam";
import PostCourse from "./pages/admin/postcourse";
import DeleteCourse from "./pages/admin/deletecourse";
import EditCourse from "./pages/admin/editcourse";
import ViewAllCoursesPage from "./pages/admin/Viewcourses";
import ViewAllEnquiry from "./pages/admin/Viewallenquiry";
import ViewAllTransaction from "./pages/admin/Viewtransaction";
import PaymentPage from "./pages/Paymentpage";
import DeleteEnquiryPage from "./pages/admin/deleteEnquiry";

const LazyAbout = lazy(()=>import("./pages/About"));
const LazyContact = lazy(()=>import("./pages/Contact"));

const App = () => {
  // const role = "ADMIN";
  const router = createBrowserRouter([
    {
      path:'/home',
      element: <Suspense fallback={<Spinner/>}>
        {/* {
          role === "USER" ? <Home/> : <Home/>
        } */}
        <Home/>
      </Suspense>
    },
    {
      path: '/about',
      element :<Suspense fallback={<Spinner/>}><LazyAbout/></Suspense>
    },
    {
      path: '/contact',
      element :<Suspense fallback={<Spinner/>}><LazyContact/></Suspense>
    },
    {
      path: '/login',
      element :<Suspense fallback={<Spinner/>}><Login/></Suspense>
    },
    {
      path: '/register',
      element :<Suspense fallback={<Spinner/>}><Register/></Suspense>
    },
    {
      path: '/team',
      element :<Suspense fallback={<Spinner/>}><Manageteam/></Suspense>
    },
    {
      path: '/inquiry',
      element :<Suspense fallback={<Spinner/>}><InquiryForm/></Suspense>
    },
    {
      path: '/courses',
      element :<Suspense fallback={<Spinner/>}><ViewAllCourses/></Suspense>
    },
    {
      path: '/profile',
      element :<Suspense fallback={<Spinner/>}><ProfilePage/></Suspense>
    },
    {
      path: '/dashboard',
      element :<Suspense fallback={<Spinner/>}>
        {/* {
          role === "USER" ? <Login/> : <Dashboard/>
        } */}
        <Dashboard/></Suspense>
    },
    {
      path: '/postcourse',
      element :<Suspense fallback={<Spinner/>}><PostCourse/></Suspense>
    },
    {
      path: '/deletecourse',
      element :<Suspense fallback={<Spinner/>}><DeleteCourse/></Suspense>
    },
    {
      path: '/editcourse',
      element :<Suspense fallback={<Spinner/>}><EditCourse/></Suspense>
    },
    {
      path: '/view',
      element :<Suspense fallback={<Spinner/>}><ViewAllCoursesPage/></Suspense>
    },
    {
      path: '/view/enquiry',
      element :<Suspense fallback={<Spinner/>}><ViewAllEnquiry/></Suspense>
    },
    {
      path: '/transaction',
      element :<Suspense fallback={<Spinner/>}><ViewAllTransaction/></Suspense>
    },
    {
      path: '/payment',
      element :<Suspense fallback={<Spinner/>}><PaymentPage/></Suspense>
    },
    {
      path: '/denq',
      element :<Suspense fallback={<Spinner/>}><DeleteEnquiryPage/></Suspense>
    }
    

  ])
  return (
    
    <RouterProvider router={router}></RouterProvider>
  )
}
export default App;
