
import './App.css';
import { Component } from 'react';
import Film from "./Film"



class App extends Component{

    state = {
        data: []
    }

    componentDidMount(){
        fetch('https://video-cassettes-app-api.herokuapp.com/api/cassettes/all')
        .then(response => response.json())
        .then(data => {
            console.log(data);
            this.setState({data})
        });
    }

render(){
    return(
        <div>
            {this.state.data.map(film => <Film info={film}/>)}
        </div>
    )
}

}

export default App;
