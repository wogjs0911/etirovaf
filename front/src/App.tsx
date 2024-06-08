import {Route, Routes } from 'react-router-dom';
import './App.css'
import Layout from "@components/Layout";
import Index from "@pages/Index";
import Home from "@pages/Home";
import DreamSearch from "@pages/DreamSearch";
import Dream from "@pages/Dream/index";
import DreamCreate from "@pages/DreamCreate";
import DreamFilter from "@pages/DreamFilter";
import DreamNotice from "@pages/DreamNotice";
import Login from "@pages/Login";
import Signup from "@pages/Signup";
import MemberInfoProvider from '@components/_providers/MemberInfoProvider';
import { Suspense } from 'react';
import Fallback from '@components/Fallback/Fallback';

function App() {

  return (
      <MemberInfoProvider>
          <Layout>
            <Routes>
              <Route path='/' element={<Index />}/>
              <Route path='/home' element=
                  {
                    <Suspense fallback={<Fallback />}>
                      <Home />
                    </Suspense>
                  }
              />
              <Route path='/login' element={<Login />}/>
              <Route path='/signup' element={<Signup />}/>
              <Route path='/search' element={<DreamSearch />}/>
              <Route
                  path='/dream/:id'
                  element={
                    <Suspense fallback={<Fallback />}>
                      <Dream />
                    </Suspense>
                  }
              />
              <Route path='/dream/create' element={<DreamCreate />}/>
              <Route path='/dreams/filter' element={<DreamFilter />}/>\
              <Route path='/dreams/notice' element={<DreamNotice />}/>
            </Routes>
          </Layout>
      </MemberInfoProvider>
  )
}

export default App
