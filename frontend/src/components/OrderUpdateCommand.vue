<template>
    <v-card outlined>
        <v-card-title>
            OrderUpdate
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="orderUpdate"
            >
                OrderUpdate
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'OrderUpdateCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = '';
        },
        watch: {
        },
        methods: {
            orderUpdate() {
                this.$emit('orderUpdate', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

