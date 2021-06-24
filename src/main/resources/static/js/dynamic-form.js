const app = Vue.createApp({});
app.component('dynamic-form', {
    template: `
    <div>
        <input v-model="titleField" placeholder="Title" ref="titleInput">
        <input v-model="descriptionField" placeholder="Description" @keyup.enter="save()">    
        <button type="button" @click="save()">Save</button>
    </div>
    <div>
        <h2>Das sind deine Listen:</h2>
        <table>
            <thead>
                <tr>
                 <th>Title</th>
                 <th>Description</th>
                </tr>
            </thead>
            <tbody>
             <tr v-if="items.length === 0">
                <td colspan="2">Keine Liste vorhanden</td>
             </tr>
            <tr v-for="liste in items">
                <td>{{liste.title}}</td>
                <td>{{liste.description}}</td>
            </tr>
            <tr>
                <td>{{titleField}}</td>
                <td>{{descriptionField}}</td>
            </tr>
            </tbody>
        </table>    
    </div>
    `,
    data(){
        return {
            items: [],
            titleField: '',
            descriptionField: '',
        };
    },
    methods: {
        loadListen(){
        axios.get('/alleListen')
            .then(response => (this.items = response.data))
        },
        save(){
            axios.post('/alleListen', {
              title: this.titleField,
              description: this.descriptionField
            })
                .then((response) => {
                    this.titleField = '';
                    this.descriptionField = '';
                    this.$refs.titleInput.focus();
                    this.loadListen();
                }, (error) => {
                    console.log('Konnte Liste nicht speichern!');
                    });
        },
    },
    mounted: function() {
        this.loadListen();
    }
});
app.mount('#dynamic-form');